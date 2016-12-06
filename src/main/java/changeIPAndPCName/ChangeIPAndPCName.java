package changeIPAndPCName;

//Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 09/08/2009 10:41:42
//Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
//Decompiler options: packimports(3) 
//Source File Name:   ChangeIPAndPCName.java

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ChangeIPAndPCName
{

	static String oldIP= null;
	static String oldComputerName= null;
	static String oldDomain= null;
	static String newDomain= null;
	static String AVPath=null;
	
	static{
		newDomain= System.getProperty("newDomain", ".achievo.com");	
		AVPath=System.getProperty("AVPath", "D:\\AA8.0.0\\av8.0.0");
		System.out.println("AVPath=="+ AVPath);
	}

	public static void main(String args[]) throws IOException
	{	
		File basePath= new File(AVPath);
		if(!basePath.exists() && !basePath.isDirectory())
		{
			System.out.println("AVPath "+ AVPath+" is not existing or it is not a Directory ");
			System.exit(0);
		}
		String localIP = getMyComputerInfo().getHostAddress();
		String localComputerName = getMyComputerInfo().getHostName();
		System.out.println("localIP=="+ localIP);
		System.out.println("newDomain=="+ newDomain);
		System.out.println("localComputerName=="+ localComputerName);	
		
		System.out.println("\r\nGet localIP and localComputerName successfully.");		
		String paths[] = getpaths(filePath);
		System.out.println("Read paths.properties successfully.");

		String serverConfPath = paths[0];
		File serverConfSource = new File(basePath, serverConfPath);
		 getOldInfo(serverConfSource);
		System.out.println("Read the first file in paths.properties successfully.");
		
		
		System.out.println("Get oldIP and oldComputerName successfully.\r\n");

		System.out
				.println("\r\n************************************Start Change IP and PC Name************************************");
		try
		{
			for (int i = 0; i < paths.length; i++)
			{
				String path = paths[i];
				if (path == null)
					break;
				File source = new File(basePath, path);
				String fileString = null;
				if (source.exists() && source.isFile())
				{
					System.out.println("start to change IP and PCName for "+ path);
					fileString = getFileString(source);
				}
				else
				{
					if (!"".equals(path))
						System.out.println("Error: Can't find " + source.getCanonicalPath()
								+ ", please check whether the path is set right in paths.properties.");
					continue;
				}
				fileString = fileString.replaceAll(oldIP, localIP);
				fileString = fileString.replaceAll(oldComputerName, localComputerName);
				fileString = fileString.replaceAll(oldDomain, newDomain);
				
				// Replace the base path;
				fileString = fileString.replace("$$BASE_PATH$$", AVPath.substring(0, AVPath.indexOf("changeIPAndPCName")));
				
				File temp = new File(basePath, path + ".tmp");
				FileWriter fw = new FileWriter(temp);
				BufferedWriter out = new BufferedWriter(fw);
				out.write(fileString);
				out.close();
				fw.close();
				boolean deleted = false;
				if (source.exists() && source.isFile())
					deleted = source.delete();
				if (deleted)
					temp.renameTo(source);
				System.out.println(path + " has been replaced successfully.");
			}

			System.out.println("\r\nCongratulations! All existed files have been replaced successfully!");
			System.out
					.println("\r\n************************************End Change IP and PC Name************************************");
		}
		catch (IOException e)
		{
			throw e;
		}
		catch (SecurityException se)
		{
			throw se;
		}
	}

	private static void getOldInfo(File serverConfSource) throws IOException
	{
		Properties props= new Properties();
		
		Reader inStream =new FileReader(serverConfSource);
		props.load(inStream );
		inStream.close();
		oldIP= props.getProperty("jboss.bind.address");
		oldDomain= props.getProperty("av.domain");
		String avHost=  props.getProperty("av.host");
		oldComputerName= avHost.substring(0, avHost.indexOf(oldDomain));
		System.out.println("oldIP=="+ oldIP);
		System.out.println("oldDomain=="+ oldDomain);
		System.out.println("oldComputerName=="+ oldComputerName);	
	}

	private static String getFileString(File file) throws IOException
	{
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		FileReader comment = new FileReader(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		for (temp = br.readLine(); temp != null; temp = br.readLine())
			sb.append(temp + "\r\n");

		br.close();
		comment.close();
		return sb.toString();
	}

	private static String[] getpaths(String filePath) throws IOException
	{
		File basePath= new File(AVPath,"changeIPAndPCName");
		File file = new File(basePath, filePath);
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		FileReader comment = new FileReader(file);
		BufferedReader br = new BufferedReader(comment);
		List<String> pathList =new ArrayList<String>();
		
		String temp = null;
		temp = br.readLine();
		
		for (; temp != null; temp = br.readLine())
		{		
			pathList.add(temp.toString());			
		}

		br.close();
		comment.close();
		String paths[] = pathList.toArray(new String[0]);
		return paths;
	}

	private static InetAddress getMyComputerInfo() throws UnknownHostException
	{
		InetAddress localPC = null;
		try
		{
			localPC = InetAddress.getLocalHost();
		}
		catch (UnknownHostException e)
		{
			System.out.println("Failed to get local host info!");
			throw e;
		}
		return localPC;
	}

	static String filePath = "paths.properties";

	

}