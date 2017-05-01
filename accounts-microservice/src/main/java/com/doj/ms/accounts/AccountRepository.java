/**
 * 
 */
package com.doj.ms.accounts;

import java.util.List;

import org.json.JSONObject;


/**
 * @author Dinesh.Rajput
 *
 */
public interface AccountRepository {
	
	List<Account> getAllAccounts();
	
	Account getAccount(String number);
	
	void demoJson();
}
