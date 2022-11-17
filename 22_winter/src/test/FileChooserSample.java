package test;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileChooserSample {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Multiple file and directory selection:");
		//다중 선택 가능
		jfc.setMultiSelectionEnabled(true);
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		//'모든 파일' 필터 추가
		jfc.setAcceptAllFileFilterUsed(true);
		
		//파일필터 추가
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF and JPG images", "png", "gif", "jpg");
		jfc.addChoosableFileFilter(filter);
		FileNameExtensionFilter pdf = new FileNameExtensionFilter("Pdf file(.pdf)", "pdf");
		jfc.addChoosableFileFilter(pdf);

		int returnValue = jfc.showOpenDialog(null);	//열기 모드
		//선택 버튼 클릭인지 여부 판단
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File[] files = jfc.getSelectedFiles();
			System.out.println("Directories found\n");
			Arrays.asList(files).forEach(x -> {
				if (x.isDirectory()) {
					System.out.println(x.getAbsolutePath());
				}
			});
			System.out.println("\n- - - - - - - - - - -\n");
			System.out.println("Files Found\n");
			Arrays.asList(files).forEach(x -> {
				if (x.isFile()) {
					System.out.println(x.getAbsolutePath());
				}
			});
		}
		
		
//		int returnValue = jfc.showSaveDialog(null);	//저장모드
//		//저장 버튼 클릭인지 여부 판단
//		if (returnValue == JFileChooser.APPROVE_OPTION) {
//			File file = jfc.getSelectedFile();
//			System.out.println(file.getAbsolutePath());
//		}
	}
}
