package kodlamaio.HRMS.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.userServices.LinkedinAddressService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataaccess.abstracts.LinkedinAddressDao;
import kodlamaio.HRMS.entities.concretes.LinkedinAddress;

@Service
public class LinkedinAddressManager implements LinkedinAddressService {

	private LinkedinAddressDao linkedinAddressDao;

	@Autowired
	public LinkedinAddressManager(LinkedinAddressDao linkedinAddressDao) {
		super();
		this.linkedinAddressDao = linkedinAddressDao;
	}

	@Override
	public DataResult<List<LinkedinAddress>> getAll() {
		
		return new SuccessDataResult<List<LinkedinAddress>>(this.linkedinAddressDao.findAll(), "LinkedIn addresses listed");
	}

	@Override
	public Result add(LinkedinAddress linkedinAddress) {
		this.linkedinAddressDao.save(linkedinAddress);
		return new SuccessResult("LinkedIn address added");
	}
	
	
	
	
}
