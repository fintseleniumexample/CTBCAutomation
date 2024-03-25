//package com.ctbt.automation.util;
//
//import nu.pattern.OpenCV;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.highgui.HighGui;
//import org.opencv.videoio.VideoCapture;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WebcamCapture {
//    public static void main(String[] args) {
//        OpenCV.loadShared();
//        // Load the OpenCV native library
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//
//        // Open the default webcam (usually index 0)
//        VideoCapture camera = new VideoCapture(0);
//
//        // Check if the webcam opened successfully
//        if (!camera.isOpened()) {
//            System.out.println("Error: Unable to access the webcam.");
//            return;
//        }
//
//        // Create a window to display the camera feed (optional)
//        // You may need to install an additional library for this
//        // HighGui.imshow("Webcam Feed", new Mat());
//
//        // Capture a photo from the webcam
//        Mat frame = new Mat();
//        camera.read(frame);
//
//        // Save the captured photo (you can change the file format if needed)
//        String filePath = "blank.jpg";
//        org.opencv.imgcodecs.Imgcodecs.imwrite(filePath, frame);
//        System.out.println("Photo saved successfully: " + filePath);
//
//        // Release the webcam
//        camera.release();
//
//        //Close the OpenCV window (optional)
//         HighGui.destroyAllWindows();
//
//
//    }
//}
