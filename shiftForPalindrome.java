import java.io.*;

public class shiftForPalindrome {
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		if(test < 1 || test > 100 ){
			System.exit(0);
		}
		int output[] = new int[test];
		
		String input = new String();
		
		for(int i=0;i<test;i++){
			input = br.readLine();
			if(input.length()<1 || input.length()>300){
				System.exit(0);
			}
			
			char input_char[] = input.toCharArray();
			for(int x=0;x<input.length();x++){
				if(!Character.isAlphabetic(input_char[x])){
					System.exit(0);
				}
				if( Character.isUpperCase(input_char[x]) || Character.isDigit(input_char[x]) ){
					System.exit(0);
				}
			}
			
			StringBuffer input_buffer = new StringBuffer(input);
			
			int from_front_end =0;
			int from_back_end = 0;
			//for front end
			for(int j=0 ; j<input.length();j++){
				
				//check palindrome
				StringBuffer string_rev = new StringBuffer(input_buffer.reverse());
				input_buffer.reverse();
				String input_buffer_string = new String(input_buffer);
				String string_rev_string = new String(string_rev);
				
				if(string_rev_string.equals(input_buffer_string)){
					from_front_end = j;
					break;
				}
				if(j==input.length()-1 && !(string_rev_string.equals(input_buffer_string)) ){
					from_front_end = -1;
					break;
				}
				//shift
				char head = input_buffer.charAt(0);
				input_buffer.append(head);
				input_buffer.deleteCharAt(0);
				// front end ends
				
			}//j loop
				//for back end
				StringBuffer input_buffer_back = new StringBuffer(input);
				//for back end
				for(int j=0; j<input.length();j++){
					//check palindrome
					StringBuffer string_rev = new StringBuffer(input_buffer_back.reverse());
					input_buffer_back.reverse();
					String input_buffer_string = new String(input_buffer_back);
					String string_rev_string = new String(string_rev);
					if(string_rev_string.equals(input_buffer_string)){
						from_back_end = j;
						break;
					}
					if(j==input.length()-1 && !(string_rev_string.equals(input_buffer_string)) ){
						from_back_end = -1;
						break;
					}
					//shift
					
					char end = input_buffer_back.charAt(input.length()-1);
				    StringBuffer endbuf = new StringBuffer(""+end); 
					input_buffer_back.deleteCharAt(input.length()-1);
					endbuf.append(input_buffer_back);
					input_buffer_back = endbuf;
					//back end ends
				
			}//j loop
			if(from_back_end == -1 && from_front_end == -1){
				output[i]=-1;
			}
			else if(from_back_end <= from_front_end)
			output[i] = from_back_end;
			else 
				output[i]=from_front_end;
		}//test case
	for(int i = 0 ; i<test; i++){
		System.out.println(output[i]);
	}
		
	}
}
