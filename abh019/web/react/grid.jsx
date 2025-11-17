import React from "react";

function DispGrid({ rows = 3, cols = 3 }) {
  // Create an array of row indices
  const grid = Array.from({ length: rows }, (_, r) =>
    Array.from({ length: cols }, (_, c) => ({ r, c }))
  );

  return (
    <div
      style={{
        display: "grid",
        gridTemplateColumns: `repeat(${cols}, 50px)`,
        gap: "8px",
      }}
    >
      {grid.flat().map((cell, index) => (
        <div
          key={index}
          style={{
            width: "50px",
            height: "50px",
            background: "#8c8b7aff",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            borderRadius: "4px",
          }}
        >
          {cell.r+1},{cell.c+1}
        </div>
      ))}
    </div>
  );
}

export default DispGrid;
