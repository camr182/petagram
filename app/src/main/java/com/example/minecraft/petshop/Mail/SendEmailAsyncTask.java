package com.example.minecraft.petshop.Mail;

import android.os.AsyncTask;
import android.util.Log;

import com.example.minecraft.petshop.Activities.Contacto;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

/**
 * Created by ameza on 22/03/2017.
 */

public class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
    public Mail m;
    public Contacto activity;

    public SendEmailAsyncTask() {}

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            if (m.send()) {
                activity.displayMessage("Email sent.");
            } else {
                activity.displayMessage("Email failed to send.");
            }

            return true;
        } catch (AuthenticationFailedException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Detalles de la cuenta erróneos");
            e.printStackTrace();
            activity.displayMessage("Autenticación fallida.");
            return false;
        } catch (MessagingException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Correo fallido");
            e.printStackTrace();
            activity.displayMessage("Falló el envio del correo.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            activity.displayMessage("Unexpected error occured.");
            return false;
        }
    }
}