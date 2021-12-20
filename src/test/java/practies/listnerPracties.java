package practies;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.BaseClass;

@Listeners(com.vtiger.genericLibrary.ListnerImplementation.class)
public class listnerPracties extends BaseClass {
	@Test
	public void listner() {
		System.out.println("done");
		Assert.fail();
	}

}
