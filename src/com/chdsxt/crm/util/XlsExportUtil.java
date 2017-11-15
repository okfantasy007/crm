package com.chdsxt.crm.util;

import  java.io.FileNotFoundException;
import  java.io.FileOutputStream;
import  java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import  java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import  org.apache.poi.hssf.usermodel.HSSFCell;
import  org.apache.poi.hssf.usermodel.HSSFCellStyle;
import  org.apache.poi.hssf.usermodel.HSSFDataFormat;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class XlsExportUtil {
   //定制日期格式
	private static String DATE_FORMAT = "m/d/yy h:mm";  //"m/d/yy h:mm"
   //定制浮点数格式
    private static String NUMBER_FORMAT = "#,##0.00";
    private String xlsFileName;
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private HSSFRow row;
    /**
    * 初始化Excel
    * @param fileName
    * 导出文件
    */
    public XlsExportUtil(String fileName){
        this.xlsFileName = fileName;
        this.workbook = new HSSFWorkbook();
        this.sheet = workbook.createSheet();
    }
    public XlsExportUtil(){
        this.workbook = new  HSSFWorkbook();
        this.sheet = workbook.createSheet();
    }
    /**
     * 导出Excel文件
     * @throws XlsException
     */
     public void exportXLS() throws XlsException{
          try{
             FileOutputStream fOut = new FileOutputStream(xlsFileName);
             workbook.write(fOut);
             fOut.flush();
             fOut.close();
          } catch (FileNotFoundException e) {
             throw new XlsException("生成导出Excel文件出错!");
          } catch (IOException e) {
             throw new XlsException("写入Excel文件出错!");
        }
     }
     /**
       * 导出Excel文件
       * @throws XlsException
       */
     public void exportXLS(OutputStream ouputStream) throws XlsException{
         try{
	          workbook.write(ouputStream);
	          ouputStream.flush();
	          ouputStream.close();
         } catch (FileNotFoundException e)  {
              throw new XlsException("生成导出Excel文件出错!");
          } catch (IOException e) {
              throw new XlsException("写入Excel文件出错!");
          }
     }
    /**
     * 创建表头
     * @param headNames
     */
     public void setExcelHead(String...headNames){
    	 createRow(0);
    	 for(int i = 0;i<headNames.length;i++){
    		 setCell(i,headNames[i]);
    	 }
     }
     @SuppressWarnings("unchecked")
     public  void setExcelBody(List list,boolean hasHeader) throws SecurityException,
     NoSuchMethodException,IllegalArgumentException, 
 	 IllegalAccessException, InvocationTargetException{
    	 for(int i = 0;i<list.size();i++){
    		 Object obj = list.get(i);
    		 createRow(hasHeader?i+1:i);
    		 Class c = obj.getClass();
    		 Field[] fieldArray = c.getDeclaredFields();
    		 for(int j = 0;j<fieldArray.length;j++){
    			 Class type = fieldArray[j].getType();
    			 String getter = BaseDaoUtil.getGetter(fieldArray[j]);
    			 Method getterMethod = c.getDeclaredMethod(getter);
    			 Object fieldValue = getterMethod.invoke(obj);
    			 if(type==Integer.class||type==int.class){
    				 setCell(j,(Integer)fieldValue);
    			 }else if(type==Double.class||type==double.class){
    				 setCell(j,(Double)fieldValue);
    			 }else if(type==String.class){
    				 setCell(j,(String)fieldValue);
    			 }else if(type==java.util.Date.class||type==java.sql.Date.class){
    				 Calendar calendar = new GregorianCalendar();
    				 calendar.setTime((java.util.Date)fieldValue);
    				 setCell(j,calendar);
    			 }
    		 }
    	 }
     }
    /**
     * 增加行
  	 * @param index
     * 行号
     */
     public void createRow(int index){
         this.row = this.sheet.createRow(index);
     }

    /**
      * 设置单元格
      * @param index
      * 列号
      * @param value
      * 单元格填充
      */
    public void setCell(int index,String value){
    	HSSFCell cell = this.row.createCell(index);
    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
    	cell.setCellValue(value);
    }

    /**
      * 设置单元格
      * @param index
      * 列号
      * @param value
      * 单元格填充
      */
    public void setCell(int index,Calendar value){
    	HSSFCell cell = this.row.createCell(index);
    	cell.setCellValue(value.getTime());
    	HSSFCellStyle cellStyle = workbook.createCellStyle();//建立新的cell样式
    	cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT));//设置cell样式为定制的日期格式
    	cell.setCellStyle(cellStyle);//设置该cell日期的显示格式
    	sheet.setColumnWidth(index,5000);
    }

    /**
      * 设置单元格
      * @param index
      * 列号
      * @param value
      * 单元格填充
      */
    public void setCell(int index,int value){
      HSSFCell cell = this.row.createCell(index);
      cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
      cell.setCellValue(value);
    }

    /**
     * 设置单元格
     * @param index
     * 列号
     * @param value
     * 单元格填充
     */
    public void setCell(int index,double value){
      HSSFCell cell = this.row.createCell(index);
      cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
      cell.setCellValue(value);
      HSSFCellStyle cellStyle = workbook.createCellStyle();//建立新的cell样式
      HSSFDataFormat format = workbook.createDataFormat();
      cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT));//设置cell样式为定制的浮点数格�?
      cell.setCellStyle(cellStyle);//设置该cell浮点数的显示格式
   }
}
