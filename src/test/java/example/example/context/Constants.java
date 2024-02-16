package example.example.context;

/**
 * The Class is for Constants.
 *
 * @author Satheesh Guduru
 */
public class Constants {

	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant REPORT_DIRECTORY. */
	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/CTBCAutomationResult.html";

	/** The Constant PROJECT_NAME. */
	public final static String PROJECT_NAME = "CTBCBank";

	/** The Constant EXTENT_CONFIG_PATH. */
	public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/config/extent-config.xml";

	/** The Constant PROPERTY_FILE_PATH. */
	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";

	/** The Constant CHROME_DRIVER_PATH. */
	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
	public final static String IMAGE_PATH = WORKING_DIRECTORY + "\\src\\test\\resources\\docs\\CTBC-PHOTO.png";
	public final static String UPLOAD_DOC = WORKING_DIRECTORY + "\\src\\test\\resources\\docs\\UploadDoc.png";
	public final static String UPLOAD_PASSPORT = WORKING_DIRECTORY + "\\src\\test\\resources\\docs\\TaiwanPassport.jpg";
	public final static String EDGE_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/msedgedriver.exe";

}
