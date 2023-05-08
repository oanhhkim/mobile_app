package com.example.sinhvienapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHeplper extends SQLiteOpenHelper {
    public DBHeplper(@Nullable Context context) {
        super(context, "QUANLYSINHVIENFPTDB.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //tạo table lớp
        String sql = " CREATE TABLE LOP(maLop TEXT PRIMARY KEY, tenLop TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('CNPM01','Công nghệ phần mềm 01')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('CNPM02','Công nghệ phần mềm 02')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('CNPM03','Công nghệ phần mềm 03')";
        db.execSQL(sql);

        //tạo table chuyên ngành
        sql = " CREATE TABLE CHUYENNGANH(maChuyenNganh TEXT PRIMARY KEY, tenChuyenNganh TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO CHUYENNGANH VALUES ('ATTT','An toàn thông tin')";
        db.execSQL(sql);
        sql = " INSERT INTO CHUYENNGANH VALUES ('CNPM','Công nghệ phần mềm')";
        db.execSQL(sql);
        sql = " INSERT INTO CHUYENNGANH VALUES ('HTTT','Hệ thống thông tin')";
        db.execSQL(sql);
        //tạo table môn học
        sql = " CREATE TABLE MONHOC(maMH TEXT PRIMARY KEY, tenmonhoc TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO MONHOC VALUES ('INT1449','Phát triển ứng dụng cho các thiết bị di động')";
        db.execSQL(sql);
        sql = " INSERT INTO MONHOC VALUES ('INT1408','Chuyên đề công nghệ phần mềm')";
        db.execSQL(sql);
        //tao table calendar event
        sql = "CREATE TABLE EventCalendar(Date TEXT, Event TEXT)";
        db.execSQL(sql);
        //tạo table sinh viên
        sql = " CREATE TABLE SINHVIEN(maSv TEXT PRIMARY KEY, tenSV TEXT ," +
                " email TEXT ,hinh TEXT, maLop TEXT REFERENCES LOP(maLop), maChuyenNganh TEXT REFERENCES CHUYENNGANH(maChuyenNganh)) ";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('B19DCCN493','Đỗ Thị Kim Oanh','oanhhkim@gmail.com','avatasinhvien','CNPM01','CNPM')";
        db.execSQL(sql);
        //tạo table taikhoan
        sql = "CREATE TABLE taiKhoan(tenTaiKhoan text primary key, matKhau text)";
        db.execSQL(sql);
        //tai khoan mac dinh admin
        sql = "INSERT INTO taiKhoan VALUES('admin','admin')";
        db.execSQL(sql);


        //tạo table Diem
        sql = "CREATE TABLE DIEM(maSv TEXT REFERENCES SINHVIEN(maSv),maMH TEXT REFERENCES MONHOC(maMH)," +
                "diem REAL, PRIMARY KEY (maSv, maMH))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
