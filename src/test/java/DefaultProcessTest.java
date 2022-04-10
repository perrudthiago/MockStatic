import com.paytrue.ServiceLocatorMock;
import com.perrud.DefaultProcess;
import com.perrud.ServiceLocator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import java.lang.reflect.InvocationTargetException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mockStatic;


public class DefaultProcessTest {


    private DefaultProcess process;
    private ServiceLocator serviceLocatorMock;
    private ServiceLocatorMock serviceLocatorFake;

    @Before
    public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String className = "com.perrud.DefaultProcess";
        Class c = Class.forName(className);
        process = (DefaultProcess)c.getDeclaredConstructor().newInstance();
    }
    
    @Test
    public void callTestReal() {
        TestCase.assertEquals("Real Result", "Real Class", process.Process());
    }

    @Test
    public void callTestMock() {
        serviceLocatorMock = mock(ServiceLocator.class);

        when(serviceLocatorMock.lookup()).thenAnswer( a -> ServiceLocatorMock.getInstance().lookup());

        String result = "";
        try (MockedStatic<ServiceLocator> staticSingleton = mockStatic(ServiceLocator.class)) {
            staticSingleton.when(ServiceLocator::getInstance).thenReturn(serviceLocatorMock);

            result = process.Process();

            //staticSingleton.verify(ServiceLocator::getInstance);
            //verify(serviceLocatorMock).lookup();
        }
        TestCase.assertEquals("Mock Result", "Mock Class", result);
    }







}
