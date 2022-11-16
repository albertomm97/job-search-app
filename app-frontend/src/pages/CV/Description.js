import React from 'react';
import Button from 'react-bootstrap/Button';

const Description = () => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>CV Text</h5>
        <Button variant="outline-primary" className="companyButton">
          Edit
        </Button>
      </div>
      <div className="experiences">
        <p>
          kjdsakldjsakldjk lasdjaskjd kasjdklajd ksajdk kjdsakldjsakldjk
          lasdjaskjd kasjdklajd ksajdk kjdsakldjsakldjk lasdjaskjd kasjdklajd
          ksajdk kjdsakldjsakldjk lasdjaskjd kasjdklajd ksajdk
        </p>
        <p>
          kjdsakldjsakldjk lasdjaskjd kasjdklajd ksajdkkjdsakldjsakldjk
          lasdjaskjd kasjdklajd ksajdkkjdsakldjsakldjk lasdjaskjd kasjdklajd
          ksajdkkjdsakldjsakldjk lasdjaskjd kasjdklajd ksajdkkjdsakldjsakldjk
          lasdjaskjd kasjdklajd ksajdk
        </p>
      </div>
    </div>
  );
};

export default Description;
