package kodlamaio.HRMS.core.verifications.concretes;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.core.verifications.abstracts.VerificationCodeEmployerService;
import kodlamaio.HRMS.dataaccess.abstracts.verificationCodeDaos.VerificationCodeEmployerDao;
import kodlamaio.HRMS.entities.concretes.users.User;
import kodlamaio.HRMS.entities.concretes.verificationCodes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService {

	private VerificationCodeEmployer verificationCodeEmployer = new VerificationCodeEmployer();
	private VerificationCodeEmployerDao verificationCodeEmployerDao;

	@Autowired
	public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao) {

		this.verificationCodeEmployerDao = verificationCodeEmployerDao;
	}

	@Override
	public Result sendCode(String email) {
		String code = String.valueOf(verificationCodeEmployer.getEmployerId() + Math.random());

		verificationCodeEmployer.setCode(code);

		return new SuccessResult(email + " adresine doğrulama kodu gönderildi.");
	}

	@Override
	public Result ısVerified(boolean isVerified, Date verifiedDate, User user) {
		verificationCodeEmployer.setVerified(true);
		verificationCodeEmployer.setVerifiedDate(verifiedDate);
		verificationCodeEmployer.setEmployerId(user.getUserId());
		System.out.println(verificationCodeEmployer.getCode() + " kodu, " + verificationCodeEmployer.getVerifiedDate()
				+ " tarihinde onaylandı.");

		return new SuccessResult();
	}

	@Override
	public Result save() {
		verificationCodeEmployerDao.save(verificationCodeEmployer);
		return new SuccessResult("İş veren e-postasına gönderilen kodu onayladı.");
	}

}
