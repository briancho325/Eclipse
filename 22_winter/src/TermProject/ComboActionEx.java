package TermProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ComboActionEx extends JFrame {
	private static final long serialVersionUID = 1L;

	Map<String, FruitsInfo> menuMap = new LinkedHashMap<String, FruitsInfo>();
	DefaultListModel menuDlm = new DefaultListModel<>();
	JList<DefaultListModel<String>> jMenuList = new JList(menuDlm);
	
	DefaultListModel<FruitsInfo> purchaseDlm = new DefaultListModel<FruitsInfo>();
	JList<DefaultListModel<String>> jPurchaseList = new JList(purchaseDlm);
	
	JLabel imgLabel = null;
	JComboBox<String> strCombo = null;
	JTextField jTotalPurchaseFld = null;
	
	{
		menuMap.put("사과",  new FruitsInfo("사과",  "images/apple.jpg", 100));
		menuMap.put("바나나", new FruitsInfo("바나나", "images/banana.jpg", 500));
		menuMap.put("키위",  new FruitsInfo("키위",  "images/kiwi.jpg", 1000));
		menuMap.put("망고",  new FruitsInfo("망고",  "images/mango.jpg", 2000));
		//menuMap.put("두리안", new FruitsInfo("두리안", "images/durian.jpg", 3000));
		menuMap.put("체리",  new FruitsInfo("체리",  "images/cherry.jpg", 2500));
		String[] arrFruits = new String[menuMap.size()];
		int nIdx = 0;
		for(String fruit : menuMap.keySet()) {
			FruitsInfo fi = menuMap.get(fruit);
			menuDlm.addElement(fi);
			arrFruits[nIdx++] = fi.getName();
		}
		strCombo = new JComboBox<String>(arrFruits);
		ImageIcon images = new ImageIcon(menuMap.get("사과").getImage());
		imgLabel = new JLabel(images);
	}
	public ComboActionEx() {
		this.setTitle("콤보박스 활용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		northPanel.setLayout(new FlowLayout());
		northPanel.add(strCombo);
		northPanel.add(imgLabel);
		northPanel.add(jMenuList);
		jTotalPurchaseFld = new JTextField(10);
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String fruitName = (String) cb.getSelectedItem();
				FruitsInfo fi = menuMap.get(fruitName);
				purchaseDlm.addElement(fi);
				
				String total = jTotalPurchaseFld.getText();
				int chgTotal = Integer.parseInt(total) + fi.getPrice();
				jTotalPurchaseFld.setText(""+chgTotal);
				
				ImageIcon images = new ImageIcon(fi.getImage());
				imgLabel.setIcon(images);
			}
		});

		jPurchaseList.setSize(300, 250);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(new JLabel("구매목록"), BorderLayout.NORTH);
		centerPanel.add(new JScrollPane(jPurchaseList), BorderLayout.CENTER);
		
		jTotalPurchaseFld.setEditable(false);
		jTotalPurchaseFld.setText("0");
		JButton jDeleteBtn = new JButton("삭제");
		jDeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int nSelIdx = jPurchaseList.getSelectedIndex();
				if(nSelIdx > -1) {
					FruitsInfo fi = purchaseDlm.getElementAt(nSelIdx);
					purchaseDlm.removeElementAt(nSelIdx);
					
					String total = jTotalPurchaseFld.getText();
					int chgTotal = Integer.parseInt(total) - fi.getPrice();
					jTotalPurchaseFld.setText(""+chgTotal);
				}
			}
		});
		
		southPanel.setLayout(new FlowLayout());
		southPanel.add(new JLabel("총구매금액:"));
		southPanel.add(jTotalPurchaseFld);
		southPanel.add(jDeleteBtn);
		
		this.setSize(350, 400);
		this.setVisible(true);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new ComboActionEx();
	}
}

class FruitsInfo{
	private String name = null;
	private String image = null;
	private int price = 0;
	public FruitsInfo(String name, String image, int price) {
		this.name = name;
		this.image = image;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return name + " : "+price;
	}
}