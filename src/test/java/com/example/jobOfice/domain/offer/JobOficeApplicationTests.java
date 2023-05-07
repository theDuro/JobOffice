package com.example.jobOfice.domain.offer;

import com.example.jobOfice.domain.offer.dto.OferDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.rmi.NotBoundException;
import java.util.List;

@SpringBootTest
class JobOficeApplicationTests {
	private final OfferFacade oferFasade = new OfferFacade(
			new InMemeoryOferRepository()
	);



	@Test
	void shoud_save_4_offers_when_ther_are_now_offers_in_database() {
		//given
		List<Ofer> offerList =  List.of(new
				Ofer("3",TypeOfJob.ONSITE)
				,new Ofer("4",TypeOfJob.HYBRID)
				,new Ofer("5",TypeOfJob.ONSITE)
				,new Ofer("6",TypeOfJob.REMOTE)
		);
		//when
		oferFasade.saveOferts(offerList);
		int countOfElementsInDatabase =  oferFasade.getAllOfer().size();
		//then
		assertThat(countOfElementsInDatabase).isEqualTo(4);


	}
	@Test
	void shoud_save_2_offers_when_ther_are_offers_in_database() {
		//given
		Ofer ofer = new Ofer("2",TypeOfJob.HYBRID);
		List<Ofer> offerList =  List.of(new
						Ofer("3",TypeOfJob.ONSITE)
				,new Ofer("4",TypeOfJob.HYBRID)
				,new Ofer("5",TypeOfJob.ONSITE)
				,new Ofer("6",TypeOfJob.REMOTE)
		);
		//when
		oferFasade.saveOfer(ofer);
		oferFasade.saveOferts(offerList);
		int countOfElementsInDatabase =  oferFasade.getAllOfer().size();
		//then
		assertThat(countOfElementsInDatabase).isEqualTo(3);

	}
	@Test
	void shoud_throw_duplicate_key_expeptoion_when_offer_url_exist() {
		//given
		Ofer ofer = new Ofer("3",TypeOfJob.HYBRID);
		List<Ofer> offerList =  List.of(new
						Ofer("3",TypeOfJob.ONSITE)
				,new Ofer("4",TypeOfJob.HYBRID)
				,new Ofer("5",TypeOfJob.ONSITE)
				,new Ofer("6",TypeOfJob.REMOTE)
		);
		//when
		oferFasade.saveOfer(ofer);
		//then
		assertThatThrownBy(()->oferFasade.saveOferts(offerList)).isInstanceOf(DuplicateKeyException.class);

	}
	@Test
	void shoud_throw_not_found_exeption_when_offer_not_found() {
		assertThatThrownBy(()->oferFasade.getOferById("45")).isInstanceOf(NotBoundException.class);
	}
	@Test
	void shoud_flesh_from_jobs_from_remote_and_save_all_offer_when_repository_is_empty() {
		//give
		List<Ofer> offerList =  List.of(new Ofer("3",TypeOfJob.ONSITE)
				,new Ofer("4",TypeOfJob.HYBRID)
				,new Ofer("5",TypeOfJob.ONSITE)
				,new Ofer("6",TypeOfJob.REMOTE)
				,new Ofer("7",TypeOfJob.REMOTE)
				,new Ofer("8",TypeOfJob.REMOTE));
		//when
		oferFasade.saveOferts(offerList);
		List<OferDto> remoteOffers = oferFasade.getRemoteJobs();
		//ther
		assertThat(remoteOffers).isEqualTo(List.of(
				new Ofer("6",TypeOfJob.REMOTE)
				,new Ofer("7",TypeOfJob.REMOTE)
				,new Ofer("8",TypeOfJob.REMOTE)
		));
	}
	@Test
	void shoud_find_offer_by_id_whenOffer_was_saved() throws NotBoundException {
		//given
		Ofer ofer = new Ofer("3",TypeOfJob.HYBRID);
		//when
		oferFasade.saveOfer(ofer);
		OferDto oferDto = oferFasade.getOferById(ofer.id());
		OferDto oferDtobulidetFromOfer = OferDto.builder()
				.id(ofer.id())
				.typeOfJob(ofer.typeOfJob())
				.build();
		assertThat(oferDto).isEqualTo(oferDtobulidetFromOfer);




	}






}
