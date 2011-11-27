package springmvc.web;
 
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
 
import springmvc.model.Brand;
import springmvc.model.Car;
import springmvc.service.BrandManager;
import springmvc.service.CarManager;
 
public class CarNewController extends SimpleFormController {
 
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	Car defaultCar = new Car();
    	defaultCar.setModel("new model");
    	defaultCar.setPrice(new BigDecimal(15000));
    	return defaultCar;
    }
 
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
    	Map<Object, Object> dataMap = new HashMap<Object, Object>();
    	BrandManager brandManager = new BrandManager();
    	dataMap.put("brandList", brandManager.getBrandList());
    	return dataMap;
    }
 
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    	binder.setDisallowedFields(new String[] {"brand"});
 
    	Car car = (Car)binder.getTarget();
 
    	// set car's brand from request parameter brand id
    	BrandManager brandManager = new BrandManager();    	
    	Long brandId = null;
    	try {
	    	brandId = Long.parseLong(request.getParameter("brand"));
		} catch (Exception e) {}		
		if (brandId != null) {
			Brand brand = brandManager.getBrandById(brandId);
			car.setBrand(brand);
		}    
    }
 
    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
    	CarManager carManager = new CarManager();
    	carManager.createCar((Car)command);
 
    	return new ModelAndView(new RedirectView(getSuccessView()));
    }
 
}