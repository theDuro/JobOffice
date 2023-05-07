package com.example.jobOfice.domain.offer;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class OferFasadeTest  {
    @Test
    public void schoud_save_4_oferts_when_is_no_ofer_in_database(){
        //given

        //when
        //then


    }
    @Test
    public void schoud_save_only_2_oferts_when_repository_had_4_added_with_offer_urls(){
        //given

        //when
        //then


    }
    @Test
    public void schoud_throw_duplikate_key_exception_when_offer_url_exist(){

        //when
        //then


    }
    @Test
    public void schoud_throw_not_found_exeption_when_offer_not_found(){
        //given

        //when
        //then


    }
    @Test
    public void schoud_fetch_from_remote_and_save_all_offers_whenrepository_is_empty(){
    }
    @Test
    public void schoud_find_offer_by_id_when_offer_was_saved(){

    }
}
