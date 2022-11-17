import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

import Language from './Languaje';

import { getLanguages } from '../../services/CV/getLanguages';

const Languages = () => {
  const [languages, setLanguages] = useState([]);

  useEffect(() => {
    setLanguages(getLanguages());
  }, []);

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
        {languages.map((language) => (
          <Language key={language.id} data={language} />
        ))}
      </div>
    </div>
  );
};

export default Languages;
