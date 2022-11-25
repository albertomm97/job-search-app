import React from 'react';
import Button from 'react-bootstrap/esm/Button';
import Form from 'react-bootstrap/Form';

import { getUserOffers } from '../../services/signUpOfferService';
import { useLocation } from 'wouter';
import { useUser } from '../../hooks/useUser';

const UserOffers = () => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/candidate-login');

  const desiredOffer = getUserOffers({ id: userData.id });

  const handleSubmit = (event) => {
    event.preventDefault();
  };

  return desiredOffer.map((offer) => {
    return (
      <div key={offer.id} className="cvPartsContainer center">
        <h2>My offers</h2>
        <div className="cvPart offerDetail">
          <div className="separator">
            <img className="cvPic" src="/logo192.png" />
            <div className="candidateDetails">
              <h4>{offer.title}</h4>
              <p>{offer.company}</p>
              <p>{offer.category}</p>
              <p>{offer.salary}</p>
            </div>
          </div>
          <Form onSubmit={handleSubmit} className="cancelInscriptionButton">
            <Button className="cancelInscriptionButton" type="submit">
              Cancel Inscription
            </Button>
          </Form>
        </div>
      </div>
    );
  });
};

export default UserOffers;
