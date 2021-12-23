/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.praktikum.c.tiga.ws.praktikum.c.tiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@Controller
public class ArtisController {
    ArrayList<String> buku = new ArrayList<>();
    @RequestMapping("/addbook")
    @ResponseBody
    public String createBook(HttpServletRequest data){
        String result="One Book Added Successfully";
        String title = data.getParameter("judul");
        //http://localhost:8080/addbook?judul=Mencoba
        buku.add(title);
        return result;
    }
    
    @RequestMapping("/book")
    @ResponseBody
    public ArrayList<String> getBook(){
        Book buku = new Book();
        return buku.newBook();
    }
    
    @CrossOrigin 
    @RequestMapping(value="/bookjson", produces={
        MediaType.APPLICATION_JSON_VALUE //produces untuk mengembalikan di return sesuai mediatype
    })
    @ResponseBody
    public ArrayList<String> getJsonBook(){
        //ArrayList<String> buku = new ArrayList<>();
        buku.add("Coba Meraih Cinta, Haris Setiawan 2020");
        buku.add("Menaklukkan Hati, Titis W 2021");
        buku.add("Cintaku Kabur Kanginan, Miss X 2019");
        buku.add("Cintaku Ku Tinggal di Palembang, DW 2021");
        buku.add("Kenangan Manisku Dimana-Mana, DP 2022");
        return buku;
    }
    
    
    @RequestMapping("/cariartis")
    public String getArtis(Model model,HttpServletRequest data){
        String caridata = data.getParameter("artis");
        String datanotfound = "";
        List<String> buffer = new ArrayList<>(); //penyimpanan data sementara
        
        ArrayList<List<String>> daftar = new ArrayList<>();
        ArrayList<List<String>> senddata = new ArrayList<>(); //tempat penyimpanan data
        
        daftar.add(Arrays.asList("Nadzira","DKI"));
        daftar.add(Arrays.asList("Okky","Jawa Tengah"));
        daftar.add(Arrays.asList("Damas","Kediri"));
        
        for(int idx = 0;idx<daftar.size(); idx++){
            buffer = daftar.get(idx);
            if(buffer.get(0).contains(caridata)){
                senddata.add(daftar.get(idx));
                datanotfound="";
            }
            if(senddata.isEmpty()){
                datanotfound="Tidak ditemukan";
            }
        }
        
        model.addAttribute("dataartis", senddata);
        model.addAttribute("dataisnull", datanotfound);
        return "viewArtis";
    }
    
//    @CrossOrigin
//    @RequestMapping(value="/bookxml", produces={
//        MediaType.APPLICATION_XML_VALUE //produces untuk mengembalikan di return sesuai mediatype
//    })
//    @ResponseBody
//    public ArrayList<String> getXMLBook(){
//        ArrayList<String> buku = new ArrayList<>();
//        
//        buku.add("Coba Meraih Cinta");
//        buku.add("Menaklukkan Hati");
//        buku.add("Cintaku Kabur Kanginan");
//        buku.add("Cintaku Ku Tinggal di Riau");
//        return buku;
//    }
}