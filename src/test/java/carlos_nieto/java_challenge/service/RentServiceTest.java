package carlos_nieto.java_challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carlos_nieto.java_challenge.model.TypeCar;

class RentServiceTest {

	RentService rentService;
	
	TypeCar typeCarPremium = new TypeCar(1L,"premium",300.0,5);
	TypeCar typeCarSuv = new TypeCar(2L,"suv",150.0,3);
	TypeCar typeCarSmall = new TypeCar(3L,"small",50.0,1);

    @BeforeEach                                         
    void setUp() {
    	rentService = new RentService();   	
    }
    
    @Test
    void testCalcPrice() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    	
    	Method calcPriceMethod = RentService.class.getDeclaredMethod("calcPrice", TypeCar.class, Integer.class);
    	calcPriceMethod.setAccessible(true);	
    	
        assertEquals(3000.0, calcPriceMethod.invoke(rentService, new Object[] { typeCarPremium, 10 }));
        assertEquals(1290.0, calcPriceMethod.invoke(rentService, new Object[] { typeCarSuv, 9 }));
        assertEquals(300.0, calcPriceMethod.invoke(rentService, new Object[] { typeCarSuv, 2 }));
        assertEquals(440.0, calcPriceMethod.invoke(rentService, new Object[] { typeCarSmall, 10 }));
    }
    
    @Test
    void testCalcSurcharge() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

    	Method calcSurchargeMethod = RentService.class.getDeclaredMethod("calcSurcharge", TypeCar.class, Integer.class);
    	calcSurchargeMethod.setAccessible(true);	
    	
        assertEquals(720.0, calcSurchargeMethod.invoke(rentService, new Object[] { typeCarPremium, 2 }));
        assertEquals(240.0, calcSurchargeMethod.invoke(rentService, new Object[] { typeCarSuv, 1 }));
        	
    }

}
