package springmvc.validator;
 
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
import springmvc.model.Car;
 
public class CarValidator implements Validator {
 
	public boolean supports(Class aClass) {
		return Car.class.equals(aClass);
	}
 
	public void validate(Object obj, Errors errors) {
		Car car = (Car) obj;
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "field.required", "Required field");
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Required field");
		if ( ! errors.hasFieldErrors("price")) {
			if (car.getPrice().intValue() == 0)
				errors.rejectValue("price", "not_zero", "Can't be free!");
		}		
	}
}