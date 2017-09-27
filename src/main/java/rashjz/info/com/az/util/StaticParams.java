/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.util;

/**
 *
 * @author Mobby
 */
public class StaticParams {


    public static String WINDOWS_LOCATION = "D://uploads/";  //fileI/ other location just D
    public static String LINUX_LOCATION = "/home/rashad/uploads/";  //fileI/ other location just D
    public static String OS = "Windows 10";

    public static String getUploadLocation() {
        if ((OS).equalsIgnoreCase(System.getProperty("os.name"))) {
            return WINDOWS_LOCATION;
        } else {
            return LINUX_LOCATION;
        }

    }

}
