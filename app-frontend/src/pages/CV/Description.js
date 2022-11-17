import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';

import { getDescription } from '../../services/CV/getDescription';

const Description = () => {
  const [description, setDescription] = useState({});

  useEffect(() => {
    setDescription(getDescription());
  }, []);

  if (!description.description) {
    return <></>;
  }

  const parragraphs = description.description.split('</br>');

  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>CV Text</h5>
        <Button variant="outline-primary" className="companyButton">
          Edit
        </Button>
      </div>
      <div className="experiences">
        {parragraphs.map((p) => (
          <p key={p}>{p}</p>
        ))}
      </div>
    </div>
  );
};

export default Description;
