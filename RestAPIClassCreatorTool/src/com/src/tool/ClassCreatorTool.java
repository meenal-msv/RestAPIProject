package com.src.tool;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ClassCreatorTool {

	public static void main(String[] args)
	{
		try
		{
			File fXmlFile = new File("V:/MeenalSV/Workspaces/RestAPI/RestAPIClassCreatorTool/resources/xml/test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			
			doc.getDocumentElement().normalize();

			//System.out.println("module file name : " + doc.getDocumentElement().getNodeName());
			NodeList nameList = doc.getElementsByTagName("name");
			System.out.println("module file name : " + nameList.item(0).getChildNodes().item(0).getNodeValue());
			NodeList nList = doc.getElementsByTagName("action");
			Set<String> classNamesSet = new LinkedHashSet<>();
			Set<String> methodNamesSet = new LinkedHashSet<>();
			HashMap<String, LinkedHashSet<String>> classMethodMap = new HashMap<String, LinkedHashSet<String>>();
			//System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++)
			{

				Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element : " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					//System.out.println("Staff id : " + eElement.getAttribute("id"));
					//System.out.println("Action Code : " + eElement.getElementsByTagName("actionCode").item(0).getTextContent());
					//System.out.println("Class Name : " + eElement.getElementsByTagName("class").item(0).getTextContent());
					classNamesSet.add(eElement.getElementsByTagName("class").item(0).getTextContent());
					//System.out.println("Method Name : " + eElement.getElementsByTagName("method").item(0).getTextContent());
					//methodNames.add(eElement.getElementsByTagName("method").item(0).getTextContent());
					methodNamesSet.add(eElement.getElementsByTagName("method").item(0).getTextContent());
					if(classMethodMap.containsKey(eElement.getElementsByTagName("class").item(0).getTextContent()))
					{
						classMethodMap.get(eElement.getElementsByTagName("class").item(0).getTextContent()).add(eElement.getElementsByTagName("method").item(0).getTextContent());
					}
					else
					{
						classMethodMap.put(eElement.getElementsByTagName("class").item(0).getTextContent(), new LinkedHashSet<>());
					}
					//System.out.println("Permission : " + eElement.getElementsByTagName("permission").item(0).getTextContent());

				}
			}
			/*System.out.println("\n ------ All class names ------ \n");
			for(String className : classNamesSet)
			{
				System.out.println("Method Name : " + className);
			}
			System.out.println("\n ------ All method names ------ \n");
			for(String methodName : methodNamesSet)
			{
				System.out.println("Method Name : " + methodName);
			}*/
			System.out.println("\n ------ All class and method names in MAPS ------ \n");
			Set<String> keys = classMethodMap.keySet();
			Iterator<String> keysIterator = keys.iterator();
			while (keysIterator.hasNext()) 
			{
				//System.out.println("------------------------------------------------");
				String key = keysIterator.next();
				System.out.println("Class : " + key + " Method : " + classMethodMap.get(key));
			}
				   
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
