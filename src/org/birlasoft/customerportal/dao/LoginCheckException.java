package org.birlasoft.customerportal.dao;

public class LoginCheckException extends Exception {
	
public	LoginCheckException(String msg)
{
	super(msg);
	
}
public	LoginCheckException(Throwable e)
{
	super(e);
}

}
