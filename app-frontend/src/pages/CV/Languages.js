import React from 'react';
import Button from 'react-bootstrap/Button';

import Language from './Languaje';

const Languages = () => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Languagues</h5>
        <Button variant="outline-primary" className="companyButton">
          Add
        </Button>
      </div>
      <div className="languages">
        <Language />
        <Language />
      </div>
    </div>
  );
};

export default Languages;
