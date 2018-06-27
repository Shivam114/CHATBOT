package com.nt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
	public class Share4
	{
		/**
		 * @param args
		 * @throws Exception
		 */
		public static void main(String args[])throws Exception
		{
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Harshit1234k$");
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			int days,t=0,t1=0,sum=0,a,b,c,n,sect,inv,time,c5=0,pos=0,count=0,divrate;
			String s,s1;
			double gr=0;
			String name[]=new String[100];
			float grr4[]=new float[100];
			float max=0;
			System.out.println("Enter The Number of Comapanies");
			n=sc.nextInt();
			int period,profit2;
			float growth,gr5;
			String demand,order,buyers;
			int sale[]=new int[100];
			int index[]=new int[100];
			int profit[]=new int[100];
			int ratediv[]=new int[100];
			int c1=0,c2=0;
			int profit1[]=new int[100];
			String s2[]=new String[100];
			String s3[]=new String[100];
			int share[]=new int[100];
			String grow[]=new String[100];
			int no[]=new int[100];
			int nw[]=new int[100];
			int inv1[]=new int[100];
			float gr3[]=new float[100];
			float avg;
			int rating[]=new int[100];
			String gr2[]=new String[100];
			while(t<n)	
			{
			
				System.out.println("Enter the Name");
				s=sc.next();
				System.out.println("Enter the Domain Name");
				s1=sc.next();
				System.out.println("Enter the Share Price");
				a=sc.nextInt();
				System.out.println("Enter the No. of shares");
				b=sc.nextInt();
				System.out.println("Rate of dividend");
				divrate=sc.nextInt();
				c=a*b;
				System.out.println("Enter the Investment");
				inv=sc.nextInt();
				System.out.println("Expected time period for return in months");
				time=sc.nextInt();
				String sql2="Insert into MyProjects2 values("+String.valueOf(t+1)+",'"+s+"','"+s1+"',"+String.valueOf(a)+","+String.valueOf(b)+","+String.valueOf(c)+","+String.valueOf(inv)+")";
				ResultSet rs2=st.executeQuery(sql2);
				System.out.println("INDEX     NAME         DOMAIN_NAME         SharePrice      No. of Shares   Rate of dividend   NETWORTH     Investment");
				index[t]=t+1;
				s2[t]=s;
				s3[t]=s1;
				ratediv[t]=divrate;
				share[t]=a;
				no[t]=b;
				nw[t]=c;
				inv1[t]=inv;
				int kl=0,c4=0,sum1=0;
				String sql="Select * from MyProjects2";  
				ResultSet rs=st.executeQuery(sql);  
				while(rs.next())
			{
				System.out.println(rs.getInt(1)+"            "+rs.getString(2)+"          "+rs.getString(3)+"          "+rs.getInt(4)+"     "+rs.getInt(5)+"     "+rs.getInt(6)+"   "+rs.getInt(7)+"     "+rs.getInt(8));	
				name[t1]=rs.getString(2);
				t1++;
			}
				System.out.println("The Investment of "+(t+1)+"th Comapny is "+inv1[t]);
				int kl1=0;
				period=(int)(inv1[t]/time);
				System.out.println(period);
				System.out.println("Enter the number of sectors a company has");
				sect=sc.nextInt();
				System.out.println("Growth Rate and Sales of a company in every 1 month");
				for(int i=1;i<=time;i++)
				{
					System.out.println("Enter the sale from each sector");
					for(int i1=0;i1<sect;i1++)
					{
						sale[i1]=sc.nextInt();
						sum=sum+sale[i1];
						}
					profit2=sum-period;
					sum1=sum1+sum;
					profit1[c4]=profit2;
					growth=(float)profit2/period;
					gr3[c4]=growth;
					System.out.println("Profit is "+profit1[c4]+" and growth rate is "+growth);
					c4++;
					sum=0;
				}
				System.out.println("The total revenue is "+sum1);
				float add=0;
				c4=0;
				for(int i2=0;i2<time;i2++)
				{
					add=add+gr3[i2];
				}
				avg=add/time;
				String ss=String.format("%.2f",avg);
				int c3=inv1[t];
				int diff=sum1-c3;
				float gr1=Growth(diff,c3);
				float ra1=diff/c3;
				String ss2=String.format("%.2f",gr1);
				String ss1=String.format("%.2f",ra1);
				System.out.println("Enter the demand of the product (More/Less)");
				demand=sc.next();
				System.out.println("Enter the ratings of the product out of 5");
				rating[t]=sc.nextInt();
				System.out.println("Profit of "+(t+1)+"th company is Rs "+diff+" and growth rate is "+ss+" rate of return is "+ss1);
				float pri=(1+avg);
				double acc=sum1-inv1[t];
				double div=acc/c3;
				String returnrate=String.format("%.3f", div);
				System.out.println(sum1+" "+returnrate);
				double div1=no[t]*share[t]*ratediv[t]*0.01;
				int finalPrice=(int)(div1/(ra1-avg));
				System.out.println("Price is "+finalPrice);
				String sql4="Insert into Gain81 values("+String.valueOf(t)+","+String.valueOf(diff)+",'"+ss+"','"+ss1+"',"+String.valueOf(finalPrice)+",'"+demand+"',"+String.valueOf(rating[t])+")";
				ResultSet rs5=st.executeQuery(sql4);
				System.out.println("Index     Profit   GrowthRate    RateofReturn      Price     Demand     Order");
				String sql3="Select * from Gain81";
				ResultSet rs6=st.executeQuery(sql3);
				String s23;
				while(rs6.next())
				{
					System.out.println(rs6.getInt(1)+"             "+rs6.getInt(2)+"     "+rs6.getString(3)+"      "+rs6.getString(4)+"    "+rs6.getInt(5)+"    "+rs6.getString(6)+"    "+rs6.getInt(7));
					s23=rs6.getString(4);
					gr5=Float.parseFloat(s23);
					grr4[t]=gr5;
				}
				finalPrice=0;
				pri=0;
				acc=0;
				sum1=0;
				diff=0;
				ra1=0;
				avg=0;
				t++;
				}
			for(int j1=0;j1<t;j1++)
			{
				if((grr4[j1]>max)&&(rating[j1]>=4))
				{
					max=grr4[j1];
					pos=j1;
				}
			}
			System.out.println(name[pos]);
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}
		public static float Growth(float diff1,float c4)
		{
			return (diff1/c4)*100;
		}
			}
