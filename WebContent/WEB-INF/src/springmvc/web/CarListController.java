package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springmvc.service.CarManager;

public class CarListController implements Controller {
	
	private CarManager carManager;
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("carList");
		modelAndView.addObject("carList", carManager.getCarList());
		
		return modelAndView;
 	 }
	
	public CarManager getCarManager() {
		return carManager;
	}
	
	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}
}