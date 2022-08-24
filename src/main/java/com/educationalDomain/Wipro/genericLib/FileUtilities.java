package com.educationalDomain.Wipro.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author Prateek
 *
 */
public class FileUtilities
{
	public static Connection con;
	/**
	 * It is used to read the data from the property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyFile(String key) throws FileNotFoundException, IOException
	{
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.datapropertyfile));
		return p.getProperty(key);
	}
	/**
	 * It is used to read the data from the excel file
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] readExcelData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(AutoConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rownum = sh.getLastRowNum();
		short cellnum = sh.getRow(1).getLastCellNum();
		
		Object obj[][]=new Object[rownum][cellnum];
		for(int i=0;i<rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
			obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			System.out.println(obj[i][j]);
			}
		}
		return obj;
	}
	/**
	 * It is used to read the data from Database
	 * @return
	 * @throws SQLException
	 */
	public Connection getDataFromDB() throws SQLException
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		return con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skillrary","root","root");
		
	}
	public String queryExecution(String query,int column,String expdata) throws SQLException
	{
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			if(result.getString(column).equals(expdata))
			{
				break;
			}
			else
			{
				Reporter.log("data not matching");
			}
		}
		return expdata;
	}
	/**
	 * Used to close the database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
}
