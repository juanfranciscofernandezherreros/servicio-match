package com.fernandez.basketball.match.dto;

public class FileInfo {
    private String file1;
    private String file2;

    public FileInfo() {
    }

    public FileInfo(String file1, String file2) {
        super();
        this.file1 = file1;
        this.file2 = file2;
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    @Override
    public String toString() {
        return String.format("FileInfo [file1=%s, file2=%s, url=%s]", file1, file2);
    }
}
