package com.onedirect.sftp.DTO.ThirdPartyDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Data
public class SftpTicketInputDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    public String member_id;
    public String card_type;
    public String title;
    public String card_name;
    public String first_name;
    public String last_name;
    public String gender;
    public String tier_start_date;
    public String tier_end_date;
    public String mobile;
    public String email;
    public String acquiring_location;
    public String city;
    public String state;
    public String country;
    public String zipcode;
    public String status;
    public String citi_points;
    public String fc_points;
    public String fc_points_secondary;
    public String bonus_points;
    public String points_earned;
    public String ssl_spend;
    public String zone;
    public String ps_assigned;
    public String agent_email;






}
