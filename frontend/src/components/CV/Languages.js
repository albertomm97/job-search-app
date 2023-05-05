import React from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

import Language from './Languaje';

const Languages = ({ data }) => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Languagues</h5>
        <Link to="/cv/add-language">
          <Button variant="outline-primary" className="companyButton">
            Add
          </Button>
        </Link>
      </div>
      <div className="languages">
        {data.map((language) => (
          <Language key={language.id} data={language} />
        ))}
      </div>
    </div>
  );
};

export default Languages;
