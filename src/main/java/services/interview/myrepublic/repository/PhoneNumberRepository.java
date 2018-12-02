package services.interview.myrepublic.repository;

import org.springframework.data.repository.CrudRepository;

import services.interview.myrepublic.entities.PhoneNumber;

public class PhoneNumberRepository implements CrudRepository<PhoneNumber, Integer> {

	@Override
	public <S extends PhoneNumber> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PhoneNumber> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhoneNumber findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<PhoneNumber> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PhoneNumber> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PhoneNumber entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends PhoneNumber> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
