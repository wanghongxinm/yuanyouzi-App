package com.project.laundryappui.user.Util;

import java.io.IOException;

import okhttp3.Response;

public interface OKHttpCallback {
    void onFailure(IOException e);
    void onSuccess(Response response);
}