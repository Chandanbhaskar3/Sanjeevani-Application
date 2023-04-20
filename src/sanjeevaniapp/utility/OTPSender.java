/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.utility;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import java.util.Scanner;
import sanjeevaniapp.pojo.PatientPojo;

/**
 *
 * @author ck835
 */
public class OTPSender implements Sender{

    @Override
    public boolean send(String number, String data) throws UnirestException {
        
            Unirest.setTimeouts(0,0);
            Scanner kb = new Scanner(System.in);
            String mobNo = number;
//            System.out.println("Enter your mobile no:");
//            String mobNo = kb.next();
            //int otp = 1000+((int)(Math.random()*999));
            int otp = Integer.parseInt(data);
            String url ="https://2factor.in/API/V1/5bc53c42-b735-11ed-813b-0200cd936042/SMS/"+mobNo+"/"+otp+"/OTP1";
            System.out.println("Otp is "+otp);
            GetRequest gr = Unirest.get(url);
            HttpResponse<String> response = gr.asString();
            String result = response.getBody();
            return result.contains("Success");
        }
}
