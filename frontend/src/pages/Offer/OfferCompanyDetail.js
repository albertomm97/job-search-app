import React from 'react';
import Button from 'react-bootstrap/esm/Button';
import Form from 'react-bootstrap/Form';
import { Link } from 'wouter';

import { getJobById } from '../../services/CompanyDetails/jobsOfferedService';

import { useLocation } from 'wouter';
import { useUser } from '../../hooks/useUser';

const OfferCompanyDetails = ({ params }) => {
  const [, navigate] = useLocation();
  const { isLogged, type } = useUser();

  if (!isLogged || type !== 'company') navigate('/');
  //console.log(params);
  const handleInscription = (event) => {
    event.preventDefault();
    // Get the offer and company data that we need
    // Get the currently logged user data
    // Send to server
  };

  const desiredOffer = getJobById({ id: params.id });

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
          <Link to={`/company/edit-offer/${desiredOffer.id}`}>
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
