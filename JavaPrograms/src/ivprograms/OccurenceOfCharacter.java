package ivprograms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import practice.student;

public class OccurenceOfCharacter {

	public static void main(String[] args) throws IOException {
	//countOfCharacters();
	//countOfWords();
	reverseString();
    getCountOfWord("abc");
	}
	private static int getCountOfWord(String Word) {
		int count=0;
		
		return count;
	}
	private static List<String> getUniqueWordsWithCount(){
		List<String >  l =new ArrayList<>();
		return  l;
	}
	public static void countOfCharacters() throws IOException {
		BufferedReader buff = new BufferedReader(new FileReader("C:\\Users\\Prashant\\Desktop\\ABC.txt"));
		String line = null;
		int count=0;
		HashMap<Character, Integer> map = new HashMap<>();
		while((line=buff.readLine())!= null) {
			System.out.println(line);
			char[] ch = line.toCharArray();
			for(char ch1:ch) {
				if(map.containsKey(ch1)) {
					map.put(ch1, map.get(ch1)+1);
				}else {
					map.put(ch1, 1);
				}
				count++;
			}
		}
		System.out.println(map);
		System.out.println(count);
		
	}
	
	public static void countOfWords() throws IOException {
		BufferedReader buff = new BufferedReader(new FileReader("C:\\Users\\Prashant\\Desktop\\ABC.txt"));
		String line = null;
		int count=0;
		HashMap<String, Integer> map = new HashMap<>();
		while((line=buff.readLine())!=null) {
			System.out.println(line);
			String[] words = line.split(" ");
			for(String word:words) {
				if(map.containsKey(word)) {
					map.put(word, map.get(word)+1);
				}else {
					map.put(word, 1);
				}
				count++;
			}
		}
		System.out.println(map);
		System.out.println(count);
		
	}
	public static void reverseString() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		
		String a = sc.nextLine();
		ArrayList<String> list = new ArrayList<>();
		
		String[] word = a.split(" ");
	/*	for(int i=word.length-1;i>=0;i--) {
			String s =(word[i]);
			list.add(s);
			//System.out.println(list);
			
		}*/
		//System.out.println(list);
		ArrayList<String> list1 = new ArrayList<>();
		for(String s:word) {
			list1.add(s);
		}
		System.out.println(list1);
		//list1 = (ArrayList<String>) Arrays.asList(word);
		ListIterator<String> itr = list1.listIterator(list1.size());
		
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}
}

