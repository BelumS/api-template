package com.belum.apitemplate.services;

import com.belum.apitemplate.exceptions.FileWriteFailedException;

import java.io.File;

public interface FileService {

    File generateCsv() throws FileWriteFailedException;

}
