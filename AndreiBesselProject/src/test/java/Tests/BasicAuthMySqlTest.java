package Tests;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AddRemovoPage;
import Pages.BasicAuthPage;
import Pages.LandinPage;

import driver.base;


public class BasicAuthMySqlTest extends base {
	
	
	String password;
	String username;
	
	LandinPage objLandingPage;
	BasicAuthPage objBasicAuthPage;
	 String host="localhost";
	 String port="3306";
	public BasicAuthMySqlTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void driver() throws IOException, SQLException {
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/testdata?useSSL=false&","root", "Bessel70");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from testdat where scenario='test';");
		while(rs.next())
		{
			String username=rs.getString("username");
			String password=rs.getString("password");
			this.username=username;
			this.password=password;
		}
		
		base base=new base();
		base.initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().fullscreen();
		
		
	}
	
	@Test(priority=0)
	public void test() {
		//click on first button
		
		objBasicAuthPage=new BasicAuthPage(driver);
		
		objBasicAuthPage.sendUsernamePassword(password, username);
		
		objBasicAuthPage.massageReadCorrect();
		
		
	}
	@AfterTest
	public void driverEnd() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
