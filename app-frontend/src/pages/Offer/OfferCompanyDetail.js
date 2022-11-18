import React from 'react';
import Button from 'react-bootstrap/esm/Button';
import Form from 'react-bootstrap/Form';
import { Link } from 'wouter';

import { getOffers } from '../../services/getOffers';

const OfferCompanyDetails = ({ params }) => {
  const handleInscription = (event) => {
    event.preventDefault();
    // Get the offer and company data that we need
    // Get the currently logged user data
    // Send to server
  };

  const jsonOffers = localStorage.getItem('lastSearchedOffers');

  let offers = null;
  let desiredOffer = null;
  if (jsonOffers) {
    offers = JSON.parse(jsonOffers);
    desiredOffer = offers.find((offer) => offer.id === params.id);
  }

  if (desiredOffer === undefined) {
    desiredOffer = getOffers(params);
  }

  console.log(desiredOffer);

  return (
    <div className="cvPartsContainer center">
      <h2>Offer details</h2>
      <div className="cvPart offerDetail">
        <div className="separator">
          <img className="cvPic" src="/logo192.png" />
          <div className="candidateDetails">
            <h4>{desiredOffer.title}</h4>
            <p>{desiredOffer.companyName}</p>
            <p>{desiredOffer.category}</p>
            <p>{desiredOffer.type}</p>
            <p>{desiredOffer.place}</p>
            <p>Estimated salary: {desiredOffer.salary}$</p>
          </div>
        </div>
        <Form>
          <Link to="/company/edit-offer">
            <Button variant="sucess">Edit</Button>
          </Link>
        </Form>
      </div>
      <div className="cvPart column">
        <div className="cvPartHeader">
          <h5>Requirements</h5>
        </div>
        <div className="experiences">
          <p>Minimum experience: {desiredOffer.experience} years.</p>
          <p>Minimum study level: {desiredOffer.studies}.</p>
        </div>
      </div>
      <div className="cvPart column">
        <div className="cvPartHeader">
          <h5>Description</h5>
        </div>
        <div className="experiences">
          <p>{desiredOffer.description}</p>
        </div>
      </div>
    </div>
  );
};

export default OfferCompanyDetails;
