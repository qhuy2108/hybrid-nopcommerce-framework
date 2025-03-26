package commons;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    // App Infor User
    public static final String DEV_USER_URL = "http://dev.techpanda.org/";
    public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
    public static final String LIVE_USER_URL = "http://live.techpanda.org/";

    // App Infor Admin
    public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin";
    public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
    public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";

    // Wait Infor
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;
    // Download/Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR +"uploadFiles"+SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;
    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;
    // Browser Logs/Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/" + SEPARATOR;
    // HTML Report Folder
    public static final String REPORTNG_PATH = PROJECT_PATH + "/htmlReportNG/";
    public static final String EXTENT_PATH = PROJECT_PATH + "/extent-report-results/";
    public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";
    // Data Test/Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + "/dataTest/";
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + "/enviromentConfig/";
    public static final String JAVA_VERSION = System.getProperty("java.version");
    
    // Jira
    public static final String JIRA_SITE_URL = "https://autotestinghuy.atlassian.net";
    public static final String JIRA_USERNAME = "qhuy2108@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF00UhQeoNvFSnAp9hQFH8Q2Cpq8wuv3QMTqRyASicou8YdUhb-M-EOidlRhN2X7--kSBLPDKM7vcutXJzalrehrX3D0wE4guG48Ie_K8-Dj6VMMcwqpgdPubunGhiukoCLBBAzRl7MvA5gtiFvxbJ1Ea9-XnxonaQnbUmJroObSsw=698C9E9F";
    public static final String JIRA_PROJECT_KEY = "SCRUM" ;


    public static final String BROWSER_STACK_USERNAME = "automationfc1";
    public static final String BROWSER_STACK_AUTOMATE_KEY = "HzcRC4Q1fzuQhRJYSkhz";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_STACK_USERNAME + ":" + BROWSER_STACK_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static final String SAUCELAB_USERNAME = "oauth-qhuy2108-25071";
    public static final String SAUCELAB_ACCESS_KEY = "e5ddbde2-bf64-44e4-a3e3-9935f06d590c" ;
    public static final String SAUCELAB_URL = "https://" + SAUCELAB_USERNAME + ":" + SAUCELAB_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";


    public static final String LAMBDA_USERNAME = "qhuy2108";
    public static final String LAMBDA_AUTOMATE_KEY = "8km04EJCCyTqIi6trNzayZjMzwmAHbqyp7iVUzeni0lzshlNwk" ;
    public static final String LAMBRA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";

    public static final String BITBAR_USERNAME = "gameacc2019";
    public static final String BITBAR_AUTOMATE_KEY = "7eVQ2TWyVfogAtXPnfBEZrHa2QixydZWmFDVEI776VI5a3l07i" ;
    public static final String BITBAR_URL = "https://" + BITBAR_USERNAME + ":" + BITBAR_AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";


    // Singleton pattern
    private static GlobalConstants globalInstance;
    private GlobalConstants() {
    }
    public static synchronized GlobalConstants getGlobalConstants() {

        if (globalInstance == null) {
            globalInstance = new GlobalConstants();
        }

        return globalInstance;
    }

    private static final long SINGLETON_SHORT_TIMEOUT = 5;
    private static final long SINGLETON_LONG_TIMEOUT = 30;

    /*
     * public long getSingletonShortTimeout() { return SINGLETON_SHORT_TIMEOUT;; }
     *
     * public long getSingletonLongTimeout() { return SINGLETON_LONG_TIMEOUT; }
     */
}
