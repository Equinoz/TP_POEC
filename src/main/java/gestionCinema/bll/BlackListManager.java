package gestionCinema.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.BlackList;
import gestionCinema.bo.Client;
import gestionCinema.dao.BlackListDAOJDBCImpl;

@Service
@Primary
public class BlackListManager extends CrudManager<BlackList, BlackListDAOJDBCImpl> {
	
	@Autowired
	ClientManager clientManager;
	
	public boolean isBlackListed(Client c) {
		for (BlackList bc : selectAll()) {
			if (bc.getBlackListedClient().getClientId().equals(c.getClientId())) {
				System.out.println(bc.getBlackListedClient());
				System.out.println(c);
				return true;
			}
		}
		return false;
	}
}
