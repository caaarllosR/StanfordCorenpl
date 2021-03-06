package estudos.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class IoStream {

		public ArrayList<Path> getPaths(Path directoryPath){
			//dado o path de um diretorio retorna um arrayList<Path> com o path de cada arquivo no mesmo
			ArrayList<Path> paths = new ArrayList<>();
	
			try(DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)){
				for(Path p : stream){		
					paths.add(p); 					
				}
			}catch(IOException | DirectoryIteratorException e){
				e.printStackTrace();
			}
			return paths;
		}
		
		public String getText(Path path){
			//dado o path de um arquivo texto retorna seu conteudo em um String 

			StringBuilder text = new StringBuilder();

			try(BufferedReader br = Files.newBufferedReader(path)){
			    while(br.ready()){
				text.append(br.readLine());
				}
			}catch(IOException e){
				e.printStackTrace();
			}
										
			return text.toString();						
		}		
		
		
		public void writer(Path path, Charset utf8, String text){
			
			try(BufferedWriter wr = Files.newBufferedWriter(path, utf8)){
			    wr.write(text);
			}catch(IOException e){
				e.printStackTrace();
			}						
		}
}
