package util;
import java.util.*;

public class StringClipVersion2 {
	public static void main(String[] args) {
		String string = "这是一段测试用的dsfg话，意在测试sdf此段程a's'd'f的可靠性和实用性，并且加入了数字和字符一起进行输出测试"
			+ "接下来的话里有数字第一组数字为123，第二组数字为345，第三组为符号)123452123fffddxzdqsdfwkkys21d228,1sdfx^^^m奇数时"
			+"hitherehowareyouthereimissyousomycjthisisacahractor";
//		/String string2 = "123";
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要的长度:");
		int lengthRequired = input.nextInt();
		System.out.println("请输入需要插入的字符:");
		String stringRequired = input.next();
		//new StringClip().stringProcession(4, "*", string2);
		new StringClipVersion2().stringProcession(lengthRequired, stringRequired, string);
		}


	public void stringProcession(int lengthRequired,String insertType,String targetString){
		String string = targetString;
	///		String string = "";
		int lengthRd = lengthRequired;
		String insertString = insertType;
		//需要的长度
		//此处可为动态的输入部分
		StringBuffer ss = new StringBuffer(string);List<String> container = new ArrayList<String>();
		StringBuilder finalString = new StringBuilder();
		System.out.println("string的长度为:"+string.length());
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
						}//里层if
					}//外层if
				}
				//最外层
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
						}//里层if
					}//外层if
				}
				//最外层
			}
		}
		if(length<=lengthRd) {
			//判断长度小于三的情况
			StringBuilder temp = new StringBuilder(insertString+string+insertString);
				finalString = temp;
		}
		for(int i = 0;i<becr.size();i++) {
			finalString.append(becr.get(i));
		}
		System.out.println("最终结果为:"+finalString.toString());
	}
}
