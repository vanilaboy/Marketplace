import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 19.12.17 with love.
 */
public class StaffTest {

    private Staff staff = new Staff("thiisname", "thisispaTh", "thisIsAbullShit", 2.3, 1.4, "thisIsrghhgfghj&^%");

    @Test
    public void getPathToImage() throws Exception {
        if(!staff.getPathToImage().equals("thisispaTh")) {
            Assert.fail();
        }
    }

    @Test
    public void getAbout() throws Exception {
        if(!staff.getAbout().equals("thisIsAbullShit")) {
            Assert.fail();
        }
    }

    @Test
    public void getShortAbout() throws Exception {
        if(!staff.getShortAbout().equals("thisIsrghhgfghj&^%")) {
            Assert.fail();
        }
    }

    @Test
    public void getName() throws Exception {
        if(!staff.getName().equals("thiisname")) {
            Assert.fail();
        }
    }

    @Test
    public void getCost() throws Exception {
        if(staff.getCost() != 2.3) {
            Assert.fail();
        }
    }

    @Test
    public void getNewCost() throws Exception {
        if(staff.getNewCost() != 1.4) {
            Assert.fail();
        }
    }

    @Test
    public void doSale() throws Exception {
        staff.doSale(23.45);
        if(staff.getNewCost() != 23.45) {
            Assert.fail();
        }
    }

}