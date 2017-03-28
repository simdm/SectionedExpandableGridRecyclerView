package com.fivido.sectionedexpandablegridlayout.album;

import android.media.ExifInterface;
import android.util.Log;

import com.baidu.mapapi.model.LatLng;

/**
 * Created by demeng on 3/28/17.
 */

public class AlbumHelper {

    public static LatLng getPhotoLocation(String imagePath) {
        Log.i("aaa", "getPhotoLocation==" + imagePath);
        LatLng latLng = null;

        double output1 = 0.0;
        double output2 = 0.0;
        try {
            ExifInterface exifInterface = new ExifInterface(imagePath);
            String datetime = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);// 拍摄时间
            String deviceName = exifInterface.getAttribute(ExifInterface.TAG_MAKE);// 设备品牌
            String deviceModel = exifInterface.getAttribute(ExifInterface.TAG_MODEL); // 设备型号
            String latValue = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
            String lngValue = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
            String latRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
            String lngRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
            if (latValue != null && latRef != null && lngValue != null && lngRef != null) {
                try {
                    output1 = convertRationalLatLonToFloat(latValue, latRef);
                    output2 = convertRationalLatLonToFloat(lngValue, lngRef);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

//            Toast.makeText(TestActivity.this, deviceName + ":" + deviceModel, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Toast.makeText(TestActivity.this, output1 + ";" + output1 , Toast.LENGTH_LONG).show();


        latLng = new LatLng(output1, output2);
        Log.i("aaa", "latitude==" + latLng.latitude);
        Log.i("aaa", "longitude==" + latLng.longitude);
        return latLng;
    }

    private static double convertRationalLatLonToFloat(
            String rationalString, String ref) {

        String[] parts = rationalString.split(",");

        String[] pair;
        pair = parts[0].split("/");
        double degrees = Double.parseDouble(pair[0].trim())
                / Double.parseDouble(pair[1].trim());

        pair = parts[1].split("/");
        double minutes = Double.parseDouble(pair[0].trim())
                / Double.parseDouble(pair[1].trim());

        pair = parts[2].split("/");
        double seconds = Double.parseDouble(pair[0].trim())
                / Double.parseDouble(pair[1].trim());

        double result = degrees + (minutes / 60.0) + (seconds / 3600.0);
        if ((ref.equals("S") || ref.equals("W"))) {
            return (float) -result;
        }
        return result;
    }

}
