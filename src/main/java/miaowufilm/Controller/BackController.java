package miaowufilm.Controller;

import jakarta.servlet.http.HttpServletResponse;
import miaowufilm.entity.Film;
import miaowufilm.service.FilmService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class BackController {
    @Autowired
    private FilmService filmService;

    @RequestMapping("/index/toBackstage")
    public String toBackstage(){
        return "backstage";
    }

    @RequestMapping("/ExcelDownload")
    public void excelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header={"filmId","filmname","play_number","score"};
        HSSFWorkbook workbook=new HSSFWorkbook();
        //生成一个表格“销售榜单”
        HSSFSheet sheet=workbook.createSheet("销售榜单");
        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(10);
        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历表头
        for (int i=0;i< header.length;i++){
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);
            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);
            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
        }

        //从数据库拿值出来放到表格中
        List<Film> films = filmService.findAll();
        for (int i = 0; i < films.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            Film film = films.get(i);
            HSSFCell cell = null;
            String[] names = {Math.toIntExact(film.getFilm_id()) + "",
                    film.getFilmname()+ "",
                    film.getPlay_number()+ "",
                    film.getScore()+"",};
            for (int k = 0; k < names.length; k++) {
                cell = row.createCell(k);
                //拿到属性值
                HSSFRichTextString text = new HSSFRichTextString(names[k]);
                cell.setCellValue(text);
            }
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //设导出Excel的名称为Sales.xls
        response.setHeader("Content-disposition", "attachment;filename=Sales.xls");

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());

        //关闭workbook
        workbook.close();
    }


    @RequestMapping("/Echarts")
    @ResponseBody
    public List<Film> Echarts(Model model){
        List<Film> films=filmService.findAll();
        return films;
    }
    @RequestMapping("/view")
    public String goview(){
        return "POI1";
    }
    @RequestMapping("/view1")
    public String goview1(){
        return "poi";
    }
}
