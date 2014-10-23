package pe.com.core.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excel {
    public List<List<String>> leer_CrearCurso(){
        List<List<String>> lista;
        lista = new ArrayList<List<String>>();
        try{
            FileInputStream archivo = new FileInputStream(new File("C:\\Documents and Settings\\pruebas\\My Documents\\NetBeansProjects\\MatriculaPruebas\\Documentos\\DatosParaMatricula.xls"));
            //Archivo en excel
            HSSFWorkbook archivoExcel = new HSSFWorkbook(archivo);
            //Con que hoja de excel voy a trabajar
            HSSFSheet hojaExcel = archivoExcel.getSheetAt(0);
            //Obtener las filas
            Iterator<Row> filas = hojaExcel.iterator();
            //Pasar a leer la segunda fila
            filas.next();
            
            while(filas.hasNext()){
                int cont=0;
                List<String> listaInterna= new ArrayList<String>();
                Row fila = filas.next();
                Iterator<Cell> celdas = fila.cellIterator();
                while(celdas.hasNext()){
                    Cell celda = celdas.next();
                    if(cont==2 || cont==4){
                        listaInterna.add(new String(String.valueOf((int)celda.getNumericCellValue())));
                    }else{
                        listaInterna.add(new String(celda.getStringCellValue()));
                    }
                    cont++;                        
                }
                lista.add(listaInterna);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<List<String>> leer_ModificarCurso(){
        List<List<String>> lista;
        lista = new ArrayList<List<String>>();
        try{
            FileInputStream archivo = new FileInputStream(new File("C:\\Documents and Settings\\pruebas\\My Documents\\NetBeansProjects\\MatriculaPruebas\\Documentos\\DatosParaMatricula.xls"));
            //Archivo en excel
            HSSFWorkbook archivoExcel = new HSSFWorkbook(archivo);
            //Con que hoja de excel voy a trabajar
            HSSFSheet hojaExcel = archivoExcel.getSheetAt(1);
            //Obtener las filas
            Iterator<Row> filas = hojaExcel.iterator();
            //Pasar a leer la segunda fila
            filas.next();
            
            while(filas.hasNext()){
                int cont=0;
                List<String> listaInterna= new ArrayList<String>();
                Row fila = filas.next();
                Iterator<Cell> celdas = fila.cellIterator();
                while(celdas.hasNext()){
                    Cell celda = celdas.next();
                    if(cont==2 || cont==4){
                        listaInterna.add(new String(String.valueOf((int)celda.getNumericCellValue())));
                    }else{
                        listaInterna.add(new String(celda.getStringCellValue()));
                    }
                    cont++;                        
                }
                lista.add(listaInterna);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
