package com.haima.crm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;



/**
 * @author jinxian.dou
 *
 */
public class ExcelGenerator {
	public static String encodeFileName(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
		String agent = request.getHeader("USER-AGENT");
		
		if (null != agent && -1 != agent.indexOf("MSIE")) {
			return URLEncoder.encode(fileName, "UTF8");
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
			return "=?UTF-8?B?" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
		} else {
			return fileName;
		}
	}

	/**
	 * 输出excel文件到浏览器。
	 * 
	 * @param workbook
	 * @param fileName 导出的文件名
	 * @param fileName 提示用户保存的默认文件名，eg:订单.xls
	 */
	public static void output(HttpServletRequest request, HttpServletResponse response, Workbook workbook,String fileName) {
		response.setContentType("application/vnd.ms-excel");
		try {
			response.setHeader("Content-disposition", "attachment; filename=".concat(encodeFileName(request, fileName)));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		try {
			workbook.write(response.getOutputStream());
			// response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.getOutputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Workbook createWorkbook(String srcFilePath) {
		FileInputStream fs = null;
		Workbook hSSFWorkbook = null;
		try {
			fs = new FileInputStream(URLUtils.getExcelFilePath(srcFilePath));
			POIFSFileSystem ps=new POIFSFileSystem(fs);
			hSSFWorkbook = new HSSFWorkbook(ps);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (fs != null) {
				try {
					fs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return hSSFWorkbook; 
	}
	
	/**
	 * 以流的方式导出到客户端。
	 * 
	 * @param response
	 * @param srcFilePath
	 * @param exportFileName 提示用户保存的默认文件名，eg:订单.xls
	 * @param map 传给excel模板文件的数据
	 * @throws RuntimeException
	 */
	public static void exportExcel(HttpServletRequest request, HttpServletResponse response, String srcFilePath,
			String exportFileName, Map<String, Object> map) throws RuntimeException {
		Workbook workbook = createExcel(srcFilePath, map);
		output(request, response, workbook, exportFileName + ".xls");
	}
	
	public static void exportExcelAuroWrap(HttpServletRequest request, HttpServletResponse response, String srcFilePath,
			String exportFileName, Map<String, Object> map) throws RuntimeException {
		Workbook workbook = createExcelAuroWrap(srcFilePath, map);
		output(request, response, workbook, exportFileName + ".xls");
	}

	private static Workbook createExcelAuroWrap(String srcFilePath,
			Map<String, Object> map) {
		
		FileInputStream fs = null;
		XLSTransformer transformer = null;
		Workbook hSSFWorkbook = null;
		try {
			fs = new FileInputStream(URLUtils.getExcelFilePath(srcFilePath));
			transformer = new XLSTransformer();
			hSSFWorkbook = transformer.transformXLS(fs, map);

			int sheetNum = hSSFWorkbook.getNumberOfSheets();  
	
		    HSSFCellStyle cellStyle=(HSSFCellStyle) hSSFWorkbook.createCellStyle();    
		    cellStyle.setWrapText(true);
		    HSSFFont font_data_default = (HSSFFont) hSSFWorkbook.createFont();  
	        font_data_default.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
	        font_data_default.setFontHeight((short) (8 * 20));  
	       // font_data_default.setFontName("Arial Narrow");// 字體樣式  
	        cellStyle.setFont(font_data_default);  
	        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 居中  
	        cellStyle.setWrapText(true);
	        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	       
			for (int i = 0; i < sheetNum; i++) {  
			    HSSFSheet sheet = (HSSFSheet) hSSFWorkbook.getSheetAt(0);
			    sheet.autoSizeColumn(1); 

				sheet.autoSizeColumn(1, true); 
	  
			    int rows = sheet.getLastRowNum() + 1; 
			    HSSFRow row =null;
			    for (int j = 0; j < rows; j++) {  
			        row= sheet.getRow(j);  
			       
			        if (row == null){ 
			            continue;
			    	}
			       
			        int cols = row.getLastCellNum();  
			       // row.setHeightInPoints(100);
		       
			        for (int k = 0; k < cols; k++) {  
			            HSSFCell cell = row.getCell(k);  
			            if(cell!=null) {
			             	//row.setHeight((short) 200);
			            	cell.setCellStyle(cellStyle);
			            	row.setHeightInPoints(40);
			            	
			            } 
		
			            if (cell == null){ 
			                continue;  
			        	}
			            
			        }
			       
			
			     }
			   }  
				
			   
			    
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			transformer = null;
			if (fs != null) {
				try {
					fs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return hSSFWorkbook;
	}

	/**
	 * 以流的方式导出到客户端。 {@link #createExcel(String, List, List)}
	 * 
	 * @param response
	 * @param fileName
	 * @param srcFilePath
	 * @param sheetNames
	 * @param maps 传给excel模板文件的数据
	 * @throws Exception
	 */
	public static void exportExcel(HttpServletRequest request, HttpServletResponse response, String fileName,
			String srcFilePath, List<String> sheetNames, List<Object> maps) throws RuntimeException {
		Workbook workbook = createExcel(srcFilePath, sheetNames, maps);
		output(request, response, workbook, fileName+".xls");
	}

	/**
	 * 导出excel文件。 
	 * 单个sheet.
	 * 
	 * @param srcFilePath 模板的本地路径
	 * @param map 传给excel模板文件的数据
	 * @throws Exception
	 */
	public static Workbook createExcel(String srcFilePath, Map<String, Object> map) throws RuntimeException {
		
		FileInputStream fs = null;
		XLSTransformer transformer = null;
		Workbook hSSFWorkbook = null;
		try {
			fs = new FileInputStream(URLUtils.getExcelFilePath(srcFilePath));
			transformer = new XLSTransformer();
			hSSFWorkbook = transformer.transformXLS(fs, map);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			transformer = null;
			if (fs != null) {
				try {
					fs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return hSSFWorkbook;
	}

	/**
	 * 创建excel的HSSFWorkbook对象。
	 * 多个sheet.后面可手动调用output方法输出。
	 * 
	 * @param srcFilePath 模板的本地路径
	 * @param sheetNames 每个sheet的名
	 * @param maps 每个sheet的数据
	 */
	public static Workbook createExcel(String srcFilePath, List<String> sheetNames, List<Object> maps) throws RuntimeException {
		FileInputStream fs = null;
		XLSTransformer transformer = null;
		Workbook workbook = null;
		try {
			fs = new FileInputStream(URLUtils.getExcelFilePath(srcFilePath));
			transformer = new XLSTransformer();
			workbook = transformer.transformMultipleSheetsList(fs, maps, sheetNames, "map",new HashMap<String, Object>(), 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			transformer = null;
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return workbook;
	}
	public static float getExcelCellAutoHeight(String str, float fontCountInline) {
        float defaultRowHeight = 12.00f;//每一行的高度指定
        float defaultCount = 0.00f;
        for (int i = 0; i < str.length(); i++) {
            float ff = getregex(str.substring(i, i + 1));
            defaultCount = defaultCount + ff;
        }
        return ((int) (defaultCount / fontCountInline) + 1) * defaultRowHeight;//计算
    }

    public static float getregex(String charStr) {
        
        if(charStr==" ")
        {
            return 0.5f;
        }
        // 判断是否为字母或字符
        if (Pattern.compile("^[A-Za-z0-9]+$").matcher(charStr).matches()) {
            return 0.5f;
        }
        // 判断是否为全角

        if (Pattern.compile("[\u4e00-\u9fa5]+$").matcher(charStr).matches()) {
            return 1.00f;
        }
        //全角符号 及中文
        if (Pattern.compile("[^x00-xff]").matcher(charStr).matches()) {
            return 1.00f;
        }
        return 0.5f;

    }
}
