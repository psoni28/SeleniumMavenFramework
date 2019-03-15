package configPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static String getReportConfigPath() {

		Properties properties = new Properties();
		String reportConfigPath = null;
		try {
			// load a properties file from class path, inside static method
			properties.load(new FileInputStream("src/test/resources/configuration.properties"));

			// get the property value and print it out

			reportConfigPath = properties.getProperty("reportConfigPath");
			if (reportConfigPath != null)
				return reportConfigPath;
			else
				throw new RuntimeException(
						"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return reportConfigPath;
	}
}
