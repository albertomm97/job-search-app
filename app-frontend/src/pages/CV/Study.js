import React from 'react';
import Button from 'react-bootstrap/Button';

const Study = () => {
  return (
    <div className="experience">
      <div className="experienceDetails">
        <h6>
          Master uiniversitario en tocarme los cojones me cagoe n tusmuertos
          pisaods
        </h6>
        <p>U-tad</p>
        <p>Category</p>
        <p>October 2021 - October 2121</p>
        <p>
          Description aksdjfkasdjf kak sdfjksa jfksjf ksjf ksdjf ksdjf ksdfj skf
          jsk fjkf jf kjsfkjfskdljf aksljfdskd lfj
        </p>
      </div>
      <div className="experienceButtons">
        <Button variant="outline-success">Edit</Button>
        <Button variant="outline-danger">Delete</Button>
      </div>
    </div>
  );
};

export default Study;
