package util;
import java.util.*;

public class StringClipVersion2 {
	public static void main(String[] args) {
		String string = "����һ�β����õ�dsfg�������ڲ���sdf�˶γ�a's'd'f�Ŀɿ��Ժ�ʵ���ԣ����Ҽ��������ֺ��ַ�һ������������"
			+ "�������Ļ��������ֵ�һ������Ϊ123���ڶ�������Ϊ345��������Ϊ����)123452123fffddxzdqsdfwkkys21d228,1sdfx^^^m����ʱ"
			+"hitherehowareyouthereimissyousomycjthisisacahractor";
//		/String string2 = "123";
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ�ĳ���:");
		int lengthRequired = input.nextInt();
		System.out.println("��������Ҫ������ַ�:");
		String stringRequired = input.next();
		//new StringClip().stringProcession(4, "*", string2);
		new StringClipVersion2().stringProcession(lengthRequired, stringRequired, string);
		}


	public void stringProcession(int lengthRequired,String insertType,String targetString){
		String string = targetString;
	///		String string = "";
		int lengthRd = lengthRequired;
		String insertString = insertType;
		//��Ҫ�ĳ���
		//�˴���Ϊ��̬�����벿��
		StringBuffer ss = new StringBuffer(string);List<String> container = new ArrayList<String>();
		StringBuilder finalString = new StringBuilder();
		System.out.println("string�ĳ���Ϊ:"+string.length());
		for(int i = 0;i<string.length();i++){
			String sTemp = ss.substring(i,i+1);
			container.add(sTemp);
		}
		int length = container.size();
		List<Integer> indexAll = new ArrayList<Integer>();
		for(int i = 0 ;i<length;i+=3) {
			if(i%lengthRequired==0) {
				indexAll.add(i);
			}
		}
		StringBuffer tempCon = new StringBuffer(insertString);
		List<String> becr = new ArrayList<String>();
		if(length%2!=0) {
			if(length>lengthRd) {
				for(int j = 0;j<length;j++) {
					if(j==0) {
						
						tempCon.append(string.substring(0,lengthRd));
						becr.add(tempCon.toString());
						tempCon = new StringBuffer(insertString);
					}
					if(j!=0) {
						if(j%lengthRequired==0) {
							if((j+lengthRd)<length) {
								becr.add(tempCon.append(string.substring(j,j+lengthRd)).toString());
								tempCon = new StringBuffer(insertString);
							}else {
								becr.add(tempCon.append(string.substring(j)).toString());
								tempCon = new StringBuffer(insertString);
							}
						}//���if
					}//���if
				}
				//�����
			}
		}else {
			if(length>lengthRd) {
				for(int j = 0;j<length;j++) {
					if(j==0) {
						
						tempCon.append(string.substring(0,lengthRd));
						becr.add(tempCon.toString());
						tempCon = new StringBuffer(insertString);
					}
					if(j!=0) {
						if(j%lengthRequired==0) {
							if((j+lengthRd)<length) {
								becr.add(tempCon.append(string.substring(j,j+lengthRd)).toString());
								tempCon = new StringBuffer(insertString);
							}else {
								becr.add(tempCon.append(string.substring(j)).toString());
								tempCon = new StringBuffer(insertString);
							}
						}//���if
					}//���if
				}
				//�����
			}
		}
		if(length<=lengthRd) {
			//�жϳ���С���������
			StringBuilder temp = new StringBuilder(insertString+string+insertString);
				finalString = temp;
		}
		for(int i = 0;i<becr.size();i++) {
			finalString.append(becr.get(i));
		}
		System.out.println("���ս��Ϊ:"+finalString.toString());
	}
}
